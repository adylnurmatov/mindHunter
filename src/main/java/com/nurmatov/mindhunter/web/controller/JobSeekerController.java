package com.nurmatov.mindhunter.web.controller;

import com.nurmatov.mindhunter.service.JobSeekerService;
import com.nurmatov.mindhunter.service.VacancyService;
import com.nurmatov.mindhunter.web.dto.JobSeeker.JobSeekerDto;
import com.nurmatov.mindhunter.web.dto.vacancy.VacancyDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class JobSeekerController {
    private final JobSeekerService jobSeekerService;
    private final VacancyService vacancyService;



    @GetMapping("/search")
    public List<JobSeekerDto> search(@RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        return jobSeekerService.findByName(name, email);
    }



    @GetMapping("/job_seekers")
    public List<JobSeekerDto> getAllJobSeekers() {
        return jobSeekerService.getAllJobSeekers();
    }

    @PutMapping("/setStatusForJobSeeker/{vacancyId}/{userId}")
    public void setStatusForJobSeeker(@PathVariable Long vacancyId,
                                      @PathVariable Long userId,
                                      @RequestParam(required = false) String status) {
        vacancyService.setStatusOfJobSeeker(vacancyId, userId, status);
    }
    @GetMapping("/statusOfJobSeekerForVacancy")
    public List<String> statusOfJobSeekers() {
        return jobSeekerService.getStatusOfJobSeeker();
    }



    @GetMapping("/get/jobseeker/{jobSeekerId}")
    public JobSeekerDto jobSeekerResponses(@PathVariable Long jobSeekerId) {
        return jobSeekerService.getById(jobSeekerId);
    }

    @PostMapping("/create")
    public JobSeekerDto save(@RequestBody JobSeekerDto jobSeeker) {
        return jobSeekerService.save(jobSeeker);
    }


    @PostMapping("/update/jobseeker/{id}")
    public JobSeekerDto update(@PathVariable("id") Long id, @RequestBody JobSeekerDto jobSeeker) {
        return jobSeekerService.update(id, jobSeeker);
    }


    @GetMapping("/vacancies")
    public List<VacancyDto> getVacancies() {
        return vacancyService.getAll();
    }
    @GetMapping("/candidate/filter")
    public List<JobSeekerDto> filter2(@RequestParam(required = false) String position,
                                            @RequestParam(required = false) String education,
                                            @RequestParam(required = false) String country,
                                            @RequestParam(required = false) String city,
                                            @RequestParam(required = false) String experience) {
        return jobSeekerService.filter(position,education,country,city,experience);
    }


}
