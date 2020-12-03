package service;

import enums.OpinionAddStatus;
import model.OpinionModel;

import javax.ejb.LocalBean;
import java.util.List;

public interface IOpinionService {
    List<OpinionModel> getOpinions();
    OpinionAddStatus add(String opinionJson);
}
