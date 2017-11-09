package com.github.stairch.dtos;

import com.github.stairch.types.HeadType;
import com.github.stairch.types.TailType;
import com.google.gson.annotations.SerializedName;

public class StartResponseDTO {

    private String color;

    @SerializedName("head_url")
    private String headUrl;
    private String name;
    private String taunt;

    @SerializedName("head_type")
    private String headType;

    @SerializedName("tail_type")
    private String tailType;

    @SerializedName("secondary_Color")
    private String secondaryColor;

    /**
     * Default constructor.
     */
    public StartResponseDTO() {
    }

    public String getHeadType() {
        return headType;
    }

    public void setHeadType(String headType) {
        this.headType = headType;
    }

    public String getTailType() {
        return tailType;
    }

    public void setTailType(String tailType) {
        this.tailType = tailType;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    /**
     * @return the color
     */
    public final String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public final void setColor(final String color) {
        this.color = color;
    }

    /**
     * @return the headUrl
     */
    public final String getHeadUrl() {
        return headUrl;
    }

    /**
     * @param headUrl the headUrl to set
     */
    public final void setHeadUrl(final String headUrl) {
        this.headUrl = headUrl;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the taunt
     */
    public final String getTaunt() {
        return taunt;
    }

    /**
     * @param taunt the taunt to set
     */
    public final void setTaunt(final String taunt) {
        this.taunt = taunt;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "StartResponse [color=" + color + ", headUrl=" + headUrl + ", name=" + name + ", taunt=" + taunt + "]";
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((headUrl == null) ? 0 : headUrl.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((taunt == null) ? 0 : taunt.hashCode());
        result = prime * result + ((headType == null) ? 0 : headType.hashCode());
        result = prime * result + ((tailType == null) ? 0 : tailType.hashCode());
        result = prime * result + ((secondaryColor == null) ? 0 : secondaryColor.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StartResponseDTO other = (StartResponseDTO) obj;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (headUrl == null) {
            if (other.headUrl != null)
                return false;
        } else if (!headUrl.equals(other.headUrl))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (taunt == null) {
            if (other.taunt != null)
                return false;
        } else if (!taunt.equals(other.taunt))
            return false;
        if (headType == null) {
            if (other.headType != null)
                return false;
        } else if (!headType.equals(other.headType))
            return false;
        if (tailType == null) {
            if (other.tailType != null)
                return false;
        } else if (!tailType.equals(other.tailType))
            return false;
        if (secondaryColor == null) {
            if (other.secondaryColor != null)
                return false;
        } else if (!secondaryColor.equals(other.secondaryColor))
            return false;
        return true;
    }

}