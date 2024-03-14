package com.nurmatov.mindhunter.web.controller;

import com.nurmatov.mindhunter.domain.entity.userInfo.Education;
import com.nurmatov.mindhunter.domain.entity.userInfo.Position;
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
    public List<JobSeekerDto> search(@RequestParam(required = false) String name) {
        return jobSeekerService.findByName(name);
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



    @GetMapping("/get/jobseeker/{jobSeekerId}")
    public JobSeekerDto jobSeekerResponses(@PathVariable Long jobSeekerId) {
        return jobSeekerService.getById(jobSeekerId);
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
    public List<JobSeekerDto> filter2(@RequestParam(required = false) Position position,
                                            @RequestParam(required = false) Education education,
                                            @RequestParam(required = false) String country,
                                            @RequestParam(required = false) String city,
                                            @RequestParam(required = false) String experience) {
        return jobSeekerService.filter(position,education,country,city,experience);
    }


}
