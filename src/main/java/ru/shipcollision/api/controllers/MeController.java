package ru.shipcollision.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.shipcollision.api.exceptions.NotFoundException;
import ru.shipcollision.api.exceptions.ForbiddenException;
import ru.shipcollision.api.helpers.SessionHelper;

import javax.servlet.http.HttpSession;

/**
 * Контроллер для доступа к методам текущего пользователя.
 */
@RestController
@RequestMapping(path = "/me")
public class MeController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity doGetMe(HttpSession session) throws ForbiddenException, NotFoundException {
        return ResponseEntity.ok().body(new SessionHelper(session).getCurrentUser());
    }
}
