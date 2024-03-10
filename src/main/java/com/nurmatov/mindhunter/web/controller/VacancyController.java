package com.nurmatov.mindhunter.web.controller;


import com.nurmatov.mindhunter.domain.entity.user.User;
import com.nurmatov.mindhunter.domain.exception.ResourceNotFoundException;
import com.nurmatov.mindhunter.repository.UserRepository;
import com.nurmatov.mindhunter.repository.VacancyRepository;
import com.nurmatov.mindhunter.service.VacancyService;
import com.nurmatov.mindhunter.web.dto.vacancy.VacancyDto;
import com.nurmatov.mindhunter.web.mapper.vacancy.VacancyMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;
    private final UserRepository userRepository;
    private final VacancyRepository vacancyRepository;
    private final VacancyMapper vacancyMapper;



    @GetMapping("/vacancies")
    public List<VacancyDto> all() {
        return vacancyMapper.toDtos(vacancyRepository.findAll());
    }


    @GetMapping("/vacancy/{vacancyId}")
    public VacancyDto getByIdVacancy(@PathVariable Long vacancyId) {

        return vacancyMapper.toDto(vacancyRepository.findById(vacancyId).orElseThrow(() ->
                new ResourceNotFoundException("vacancy not found with id: " + vacancyId)));
    }

    @PostMapping("/vacancy/{employerId}")
    public VacancyDto save(@PathVariable Long employerId,
                                @RequestBody VacancyDto vacancyRequest) {
        return vacancyService.saveVacancy(employerId, vacancyRequest);
    }


    @DeleteMapping("/delete/{vacancyId}")
    public boolean delete(@PathVariable("vacancyId") Long vacancyId) {
        return vacancyService.delete(vacancyId);
    }

    @GetMapping("/vacancy/search")
    public List<VacancyDto> vacancySearch(@RequestParam(required = false) String search,
                                            @RequestHeader(name = "Authorization") String token) {
        System.out.println("the token:" + token + "1");
        return vacancyService.searchVacancy(search);
    }
    @GetMapping("/search")
    public List<VacancyDto> vacancySearch2(@RequestParam(required = false) String search) {

        return vacancyService.searchVacancy(search);
    }



    @GetMapping("/vacancy/filter")
    public List<VacancyDto> filter(@RequestParam(required = false) String category, @RequestParam(required = false) String position, @RequestParam(required = false) String country,
                                                    @RequestParam(required = false) String city, @RequestParam(required = false) String experience, @RequestParam(required = false)
                                                    String typeOfEmployments, @RequestParam(required = false) Boolean salary,
                                                    @RequestParam(required = false) Boolean date) {


        return vacancyService.filter(category, position, country, city, experience, typeOfEmployments, salary, date);
    }

    @GetMapping("/employer/vacancies/search/{userId}")
    List<VacancyDto> employerVacanciesSearchUserId(@PathVariable Long userId,
                                                        @RequestParam(required = false) String search,
                                                        @RequestHeader(name = "Authorization") String token) {
        return vacancyService.employerVacanciesSearchUserId(userId, search);
    }

    @GetMapping("/employer/vacancies/filter/{userId}")
    List<VacancyDto> employerVacanciesFilterUserId(@PathVariable
                                                        Long userId, @RequestParam(required = false) String respondedCount,
                                                        @RequestParam(required = false) String byDate, @RequestParam
                                                                (required = false) String byStatusOfVacancy) {

        return vacancyService.employerVacanciesFilterUserId(userId, respondedCount, byDate, byStatusOfVacancy);
    }



    @GetMapping("/vacancies/{userId}")
    public List<VacancyDto> getAllMyVacancies(@PathVariable Long userId,
                                                   @RequestHeader(name = "Authorization") String token) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User not found!" + userId));
        return vacancyService.getMyVacancies(user.getId());
    }

    @PostMapping("/update/vacancy/{vacancyId}")
    public VacancyDto updateVacancy(@PathVariable Long vacancyId,
                                         @RequestBody VacancyDto vacancyRequest,
                                         @RequestHeader(name = "Authorization", required = false) String token) {

        return vacancyService.update(vacancyId, vacancyRequest);
    }



    @GetMapping("/aboutVacancy/{vacancyId}")
    public VacancyDto aboutVacancy(@PathVariable Long vacancyId) {
        return vacancyService.aboutVacancy(vacancyId);
    }

    @GetMapping("/sortedTwoSameVacancy/{vacancyId}")
    public List<VacancyDto> sortedTwoVacancy(@PathVariable Long vacancyId) {
        return vacancyService.sortedTwoVacancies(vacancyId);
    }

    @GetMapping("/popularCategory")
    public List<VacancyDto> getCategoryCounts() {
        return vacancyService.getVacancyCountByCategory();
    }



    @GetMapping("/get/list/popular/position")
    public List<VacancyDto> getPopularPositions(){
        return vacancyService.getPopularPosition();
    }
}
