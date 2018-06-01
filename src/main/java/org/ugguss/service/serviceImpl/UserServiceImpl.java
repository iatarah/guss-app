package org.ugguss.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ugguss.model.User;
import org.ugguss.repository.IUserRepository;
import org.ugguss.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public User registerUser(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public User getCurrentUser(int userId) {
        return iUserRepository.getOne(userId);
    }
}