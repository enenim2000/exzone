package com.exzone.service.dao;

import com.exzone.model.dao.Consumer;
import com.exzone.repository.dao.ConsumerRepository;
import com.exzone.util.PageRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService{
    private final ConsumerRepository consumerRepository;

    @Autowired
    public ConsumerService(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    public Page<Consumer> getConsumers(){
        return consumerRepository.findAll(PageRequestUtil.getPageRequest());
    }

    public Consumer getConsumer(Long id){
        return consumerRepository.findOrFail(id);
    }

    public Consumer getConsumerByEmail(String email) {
        return consumerRepository.findByEmail(email).orElse(null);
    }

    public Consumer saveConsumer(Consumer consumer){
        return consumerRepository.save(consumer);
    }
}