package com.bfs.authserver.service;

import com.bfs.authserver.dao.RegistrationTokenDAO;
import com.bfs.authserver.domain.RegistrationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RegistrationTokenService {
    private RegistrationTokenDAO registrationTokenDAOimp;

    @Autowired
    public void setRegistrationTokenDAO(RegistrationTokenDAO registrationTokenDAOimp){
        this.registrationTokenDAOimp = registrationTokenDAOimp;
    }
    @Transactional
    public List<RegistrationToken> getAllTokens(){
        return this.registrationTokenDAOimp.getAllTokens();
    }
    @Transactional
    public void updateToken(RegistrationToken registrationToken){
        registrationTokenDAOimp.updateToken(registrationToken);
    }
}
