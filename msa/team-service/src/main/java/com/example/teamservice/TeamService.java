package com.example.teamservice;

import org.springframework.stereotype.Service;

import com.example.teamservice.domain.Team;
import com.example.teamservice.domain.TeamMember;
import com.example.teamservice.domain.TeamMemberRepository;
import com.example.teamservice.domain.TeamRepository;
import com.example.teamservice.domain.dto.TeamCreateData;
import com.example.teamservice.domain.dto.TeamResponseData;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamMemberRepository teamMemberRepository;

    public TeamService(TeamRepository teamRepository, TeamMemberRepository teamMemberRepository) {
        this.teamRepository = teamRepository;
        this.teamMemberRepository = teamMemberRepository;
    }

    /**
     * 팀을 생성한다.
     *
     * @param teamCreateData 팀 생성에 필요한 정보가 담긴 객체
     * @return TeamResponseData (teamId, name, address)
     */
    public TeamResponseData save(TeamCreateData teamCreateData) {
        Team team = Team.builder()
                .name(teamCreateData.getName())
                .address(teamCreateData.getAddress())
                .build();

        team = teamRepository.save(team);

        return TeamResponseData.builder()
                .teamId(team.getId())
                .name(team.getName())
                .address(team.getAddress())
                .build();
    }

    /**
     * 팀 이름과 사용자 Id를 받아 팀에 선수로 등록한다.
     *
     * @param userId 사용자 Id
     * @param teamName 팀 이름
     */
    public void addTeamMember(Long userId, String teamName) {
        Team selectedTeam = teamRepository.findByName(teamName);

        TeamMember teamMember = TeamMember.builder()
                .team(selectedTeam)
                .userId(userId)
                .build();

        teamMemberRepository.save(teamMember);
    }

    /**
     * 사용자 번호로 팀을 반환한다.
     *
     * @param userId 조회하려는 사용자 번호
     * @return 반환할 팀 객체
     */
    public TeamResponseData getTeamByUserId(Long userId) {
        TeamMember teamMember = teamMemberRepository.findByUserId(userId);

        Team team = teamMember.getTeam();

        return TeamResponseData.builder()
                .teamId(team.getId())
                .name(team.getName())
                .address(team.getAddress())
                .build();
    }
}