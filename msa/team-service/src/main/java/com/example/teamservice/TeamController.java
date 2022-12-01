package com.example.teamservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.teamservice.domain.dto.TeamCreateData;
import com.example.teamservice.domain.dto.TeamMemberAddData;
import com.example.teamservice.domain.dto.TeamResponseData;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/team/teams")
    public TeamResponseData create(@RequestBody TeamCreateData teamCreateData) {
        return teamService.save(teamCreateData);
    }

    @SuppressWarnings("rawtypes")
	@PostMapping("/team/{userId}/teams")
    public ResponseEntity addTeamMember(@PathVariable("userId") Long id,
                                        @RequestBody TeamMemberAddData requestData) {
        teamService.addTeamMember(id, requestData.getName());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/team/{userId}/teams")
    public TeamResponseData getTeamByUserId(@PathVariable("userId") Long userId) {
        return teamService.getTeamByUserId(userId);
    }

}