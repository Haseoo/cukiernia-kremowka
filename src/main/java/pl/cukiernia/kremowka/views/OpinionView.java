package pl.cukiernia.kremowka.views;

import pl.cukiernia.kremowka.model.OpinionModel;

public final class OpinionView {
    private Long number;
    private String like;
    private String color;
    private String email;
    private String opinion;

    public Long getNumber() {
        return number;
    }

    public String getLike() {
        return like;
    }

    public String getColor() {
        return color;
    }

    public String getEmail() {
        return email;
    }

    public String getOpinion() {
        return opinion;
    }

    private OpinionView(Long number, String like, String color, String email, String opinion) {
        this.number = number;
        this.like = like;
        this.color = color;
        this.email = email;
        this.opinion = opinion;
    }

    public static OpinionView from(OpinionModel opinionModel) {
        return new OpinionView(opinionModel.getNumber(),
                opinionModel.getDoLike(),
                opinionModel.getColor(),
                opinionModel.getEmail(),
                opinionModel.getOpinion());
    }
}
