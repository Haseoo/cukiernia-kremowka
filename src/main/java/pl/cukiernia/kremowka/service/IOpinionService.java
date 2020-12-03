package pl.cukiernia.kremowka.service;

import pl.cukiernia.kremowka.enums.OpinionAddStatus;
import pl.cukiernia.kremowka.model.OpinionModel;

import java.util.List;

public interface IOpinionService {
    List<OpinionModel> getOpinions();
    OpinionAddStatus add(String opinionJson);
}
