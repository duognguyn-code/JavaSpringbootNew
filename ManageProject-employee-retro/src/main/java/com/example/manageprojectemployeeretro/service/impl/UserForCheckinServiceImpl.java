package com.example.manageprojectemployeeretro.service.impl;

import com.example.manageprojectemployeeretro.dto.UserDTO;
import com.example.manageprojectemployeeretro.dto.UserForWebClientResult;
import com.example.manageprojectemployeeretro.dto.UserRequest;
import com.example.manageprojectemployeeretro.service.UserForCheckin;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserForCheckinServiceImpl  implements UserForCheckin {
    @Override
    public List fillAll(Optional<String> field, Optional<String> sort, Optional<Integer> page) {
        return null;
    }

    @Override
    public UserDTO findById(Long id) {
        return null;
    }

    @Override
    public UserDTO save(UserRequest form) {
        return null;
    }

    @Override
    public UserDTO update(Long id, UserDTO form) {
        return null;
    }

    @Override
    public UserDTO delete(Long id) {
        return null;
    }

    @Override
    public List fillAllTimkeepingByEMP(Long idUser, Date dateFrom, Date dateTo) {
        return null;
    }

    @Override
    public List findUserNotCheckinOrError(Optional<Integer> month) {
        return null;
    }

    @Override
    public List findUserNotCheckinOrErrorByEMP(Optional<Integer> month, Long idUser) {
        return null;
    }

    @Override
    public List<UserForWebClientResult> findAllUserToWebClient() {
        return null;
    }
}
