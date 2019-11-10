package com.cn.lucky.morning.model.domain;

public class BookInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_book_info.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_book_info.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_book_info.author
     *
     * @mbg.generated
     */
    private String author;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_book_info.novel_des
     *
     * @mbg.generated
     */
    private String novelDes;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_book_info.novel_type
     *
     * @mbg.generated
     */
    private String novelType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_book_info.last_update
     *
     * @mbg.generated
     */
    private String lastUpdate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_book_info.last_new
     *
     * @mbg.generated
     */
    private String lastNew;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_book_info.id
     *
     * @return the value of m_book_info.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_book_info.id
     *
     * @param id the value for m_book_info.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_book_info.name
     *
     * @return the value of m_book_info.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_book_info.name
     *
     * @param name the value for m_book_info.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_book_info.author
     *
     * @return the value of m_book_info.author
     *
     * @mbg.generated
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_book_info.author
     *
     * @param author the value for m_book_info.author
     *
     * @mbg.generated
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_book_info.novel_des
     *
     * @return the value of m_book_info.novel_des
     *
     * @mbg.generated
     */
    public String getNovelDes() {
        return novelDes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_book_info.novel_des
     *
     * @param novelDes the value for m_book_info.novel_des
     *
     * @mbg.generated
     */
    public void setNovelDes(String novelDes) {
        this.novelDes = novelDes == null ? null : novelDes.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_book_info.novel_type
     *
     * @return the value of m_book_info.novel_type
     *
     * @mbg.generated
     */
    public String getNovelType() {
        return novelType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_book_info.novel_type
     *
     * @param novelType the value for m_book_info.novel_type
     *
     * @mbg.generated
     */
    public void setNovelType(String novelType) {
        this.novelType = novelType == null ? null : novelType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_book_info.last_update
     *
     * @return the value of m_book_info.last_update
     *
     * @mbg.generated
     */
    public String getLastUpdate() {
        return lastUpdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_book_info.last_update
     *
     * @param lastUpdate the value for m_book_info.last_update
     *
     * @mbg.generated
     */
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate == null ? null : lastUpdate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_book_info.last_new
     *
     * @return the value of m_book_info.last_new
     *
     * @mbg.generated
     */
    public String getLastNew() {
        return lastNew;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_book_info.last_new
     *
     * @param lastNew the value for m_book_info.last_new
     *
     * @mbg.generated
     */
    public void setLastNew(String lastNew) {
        this.lastNew = lastNew == null ? null : lastNew.trim();
    }
}