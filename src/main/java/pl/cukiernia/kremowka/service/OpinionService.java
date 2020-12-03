package pl.cukiernia.kremowka.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.cukiernia.kremowka.enums.OpinionAddStatus;
import pl.cukiernia.kremowka.model.OpinionModel;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.List;

@Stateless
@Named
public class OpinionService implements  IOpinionService{

    @PersistenceContext(unitName = "kremowka_PU")
    private EntityManager em;

    public List<OpinionModel> getOpinions() {
        return em.createNamedQuery("Opinions.findAll", OpinionModel.class).getResultList();
    }

    @Override
    public OpinionAddStatus add(String opinionJson) {
        var objectMapper = new ObjectMapper();
        try {
            var opinion = objectMapper.readValue(opinionJson, OpinionModel.class);
            return persist(opinion);
        } catch(IOException e) {
            return OpinionAddStatus.PARSE_ERROR;
        }
    }

    private OpinionAddStatus persist(OpinionModel opinion) {
        try {
            em.persist(opinion);
        } catch (Exception e) {
            e.printStackTrace();
            return OpinionAddStatus.ADD_ERROR;
        }
        return OpinionAddStatus.ADDED;
    }
}
