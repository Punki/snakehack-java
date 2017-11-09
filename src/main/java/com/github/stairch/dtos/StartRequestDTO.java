package com.github.stairch.dtos;

import com.google.gson.annotations.SerializedName;

public final class StartRequestDTO {
    @SerializedName("game_id")
    private String gameId;
    private int width;
    private int height;

    public StartRequestDTO() {
    }

    /**
     * @return the gameId
     */
    public final String getGameId() {
        return gameId;
    }

    /**
     * @param gameId the gameId to set
     */
    public final void setGameId(final String gameId) {
        this.gameId = gameId;
    }

    /**
     * @return the width
     */
    public final int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public final void setWidth(final int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public final int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public final void setHeight(final int height) {
        this.height = height;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "StartRequest [height=" + height + ", width=" + width + ", gameId=" + gameId + "]";
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
        result = prime * result + ((gameId == null) ? 0 : gameId.hashCode());
        result = prime * result + height;
        result = prime * result + width;
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
        StartRequestDTO other = (StartRequestDTO) obj;
        if (gameId == null) {
            if (other.gameId != null)
                return false;
        } else if (!gameId.equals(other.gameId))
            return false;
        if (height != other.height)
            return false;
        if (width != other.width)
            return false;
        return true;
    }

}
