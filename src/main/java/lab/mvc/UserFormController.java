package lab.mvc;

import lab.model.User;
import lab.mvc.form.bean.UserFormBean;
import lab.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
@Log4j2
public class UserFormController {

    private static final String ADD_USER_FORM = "adduserform";
    private static final String USER_LIST_VIEW = "userlistview";

    private UserService userService;

    @ModelAttribute("userFormBean")
    public UserFormBean getUserFormBean() {
        return new UserFormBean();
    }

    @ModelAttribute("userList")
    public List<User> getAllUsers() {
        return userService.loadAllUsers();
    }

    @RequestMapping("all")
    public String getAll() {
        return USER_LIST_VIEW;
    }

    @GetMapping("add")
    public String get() {
        return ADD_USER_FORM;
    }

    @PostMapping("add")
    public String processSubmit(@Valid UserFormBean userFormBean, Map<String, Object> model, Errors errors) {

        if (errors.hasErrors()) {
            log.info("Add User form validation failed.");
            return ADD_USER_FORM;
        }

        val user = new User(
                userFormBean.getFirstName(),
                userFormBean.getLastName());

        log.info("Adding new " + user);

        userService.saveUser(user);

        //noinspection unchecked
        ((List<User>) model.get("userList")).add(user);

        return USER_LIST_VIEW;
    }
}