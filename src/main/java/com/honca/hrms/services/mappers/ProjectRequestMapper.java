package com.honca.hrms.services.mappers;

import com.honca.hrms.models.dto.ProjectRequest;
import com.honca.hrms.models.dto.ProjectResponse;
import com.honca.hrms.models.entities.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectRequestMapper {
    ProjectRequestMapper INSTANCE = Mappers.getMapper(ProjectRequestMapper.class);

    Project mapToProject(ProjectRequest projectRequest);

}
