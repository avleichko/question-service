package com.quiz.services;

import com.quiz.dao.UiConfigDao;
import com.quiz.exceptions.StorageException;
import com.quiz.repository.UiConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionWindowImpl implements QuestionWindow {

    private final UiConfigRepository repository;

    @Autowired
    public QuestionWindowImpl(UiConfigRepository repository) {
        this.repository = repository;
    }

    @Override
    public void buildConfig(String font, String color, String title, Integer width, Integer height) {
        repository.deleteAll();
        UiConfigDao uiConfigDao = new UiConfigDao(null, font, color, title, width, height);
        repository.save(uiConfigDao);
    }


    @Override
    public String getConfig() {
        List<UiConfigDao> all = repository.findAll();
        UiConfigDao uiConfigDao = all.stream().findFirst().orElseThrow(() -> new StorageException("Ui config not set"));

        String result = String.format("font-family: '%s' !important; color: %s !important; width: %spx !important; height: %spx !important;",
                uiConfigDao.getFont(), uiConfigDao.getColor(), uiConfigDao.getWidth().toString(), uiConfigDao.getHeight().toString());
        return result;
    }

    @Override
    public String getTitle() {
        List<UiConfigDao> all = repository.findAll();
        UiConfigDao uiConfigDao = all.stream().findFirst().orElseThrow(() -> new StorageException("Ui config not set"));
        return uiConfigDao.getTitle();
    }


}
