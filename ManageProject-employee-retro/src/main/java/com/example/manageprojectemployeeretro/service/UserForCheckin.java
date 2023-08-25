package com.example.manageprojectemployeeretro.service;

import com.example.manageprojectemployeeretro.dto.UserDTO;
import com.example.manageprojectemployeeretro.dto.UserForWebClientResult;
import com.example.manageprojectemployeeretro.dto.UserRequest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserForCheckin {
    List fillAll(Optional<String> field, Optional<String> sort, Optional<Integer> page);

    UserDTO findById(Long id);

    UserDTO save(UserRequest form);

    UserDTO update(Long id, UserDTO form);

    UserDTO delete(Long id);


    List fillAllTimkeepingByEMP(Long idUser, Date dateFrom, Date dateTo);

    List findUserNotCheckinOrError(Optional<Integer> month);

    List findUserNotCheckinOrErrorByEMP(Optional<Integer> month, Long idUser);

    List<UserForWebClientResult> findAllUserToWebClient();
}
