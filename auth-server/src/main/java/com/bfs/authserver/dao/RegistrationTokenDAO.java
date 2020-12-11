package com.bfs.authserver.dao;

import com.bfs.authserver.domain.RegistrationToken;

import java.util.List;

public interface RegistrationTokenDAO {
    List<RegistrationToken> getAllTokens();
    void updateToken(RegistrationToken registrationToken);
}
