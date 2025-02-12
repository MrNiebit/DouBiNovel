package com.cn.lucky.morning.model.web.controller.admin;

import com.cn.lucky.morning.model.common.cache.CacheService;
import com.cn.lucky.morning.model.common.constant.Const;
import com.cn.lucky.morning.model.common.mvc.MvcResult;
import com.cn.lucky.morning.model.domain.User;
import com.cn.lucky.morning.model.web.tools.CaptchaUtils;
import com.google.common.collect.Maps;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class AdminIndexController {
    @Resource
    private CacheService cacheService;

    @RequestMapping(value = {"", "/", "/index"})
    public String index(Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null){
            return "redirect:/admin/logout";
        }
        model.addAttribute("user",user);
        return "admin/index";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "admin/welcome";
    }

    /**
     * 生成验证码
     *
     * @param session
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/verificationCode")
    public void setVerificationCode(HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        String random = CaptchaUtils.random();
        //输出图片
        CaptchaUtils.outputImage(random, response.getOutputStream());
        //存入结果
        session.setAttribute(Const.session.VERIFICATION_CODE, CaptchaUtils.num);
    }

    @RequestMapping("/login")
    public String login() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "redirect:/admin/index";
        }
        return "admin/login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/doLogin")
    @ResponseBody
    public MvcResult doLogin(String username, String password, String captcha, boolean rememberMe, HttpSession session) {
        MvcResult result = MvcResult.create(false);
        if (captcha == null || !Objects.equals(captcha, session.getAttribute(Const.session.VERIFICATION_CODE).toString())) {
            result.setMessage("验证码错误");
        } else if (StringUtils.isEmpty(username)) {
            result.setMessage("账号不能为空");
        } else if (StringUtils.isEmpty(password)) {
            result.setMessage("密码不能为空");
        } else {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
            try {
                subject.login(token);
                if (subject.isAuthenticated()) {
                    result.setSuccess(true);
                    result.setMessage("登录成功");
                } else {
                    result.setSuccess(false);
                    result.setMessage("登录失败");
                    token.clear();
                }
            } catch (UnknownAccountException uae) {
                result.setMessage("未知账户");
            } catch (IncorrectCredentialsException ice) {
                result.setMessage("密码不正确");
            } catch (LockedAccountException lae) {
                result.setMessage("账户已锁定");
            } catch (ExcessiveAttemptsException eae) {
                result.setMessage("用户名或密码错误次数过多");
            } catch (AuthenticationException ae) {
                result.setMessage("用户名或密码不正确");
            }
        }
        return result;
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "admin/login";
    }

    @RequestMapping("/clearCache")
    @ResponseBody
    public Map<String,Object> clearCache(){
        Map<String,Object> map = Maps.newHashMap();
        try {
            boolean isSuccess = cacheService.flushAll();
            if (isSuccess){
                map.put("code",1);
                map.put("msg","清除成功");
            }else {
                map.put("code",2);
                map.put("msg","清除失败,redis清空失败");
            }
        }catch (Exception e){
            map.put("code",2);
            if (StringUtils.isEmpty(e.getMessage())){
                map.put("msg","未知异常");
            }else {
                map.put("msg",e.getMessage());
            }
        }
        return map;
    }
}
