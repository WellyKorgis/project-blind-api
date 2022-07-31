package com.blind.api.mapping;

import com.blind.company.api.dto.response.CompanyResponse;
import com.blind.company.api.mapper.CompanyMapper;
import com.blind.company.domain.Company;
import com.blind.company.domain.CompanyCategory;
import com.blind.post.api.dto.response.PostResponse;
import com.blind.post.api.mapper.PostMapper;
import com.blind.post.domain.Post;
import org.hibernate.type.OffsetDateTimeType;
import org.hibernate.type.OffsetTimeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class MappingTests {
    @Mock
    private CompanyMapper companyMapper;

    @Mock
    private PostMapper postMapper;

    @Test
    public void shouldMapCompanyToDto() throws Exception
    {
        CompanyCategory companyCategory = new CompanyCategory(UUID.randomUUID(), "CompanyCategory");
        Company company = new Company(UUID.randomUUID(), "Company", companyCategory);

        CompanyResponse companyDto = companyMapper.INSTANCE.companyToDto(company);

        assertNotNull(companyDto);
        assertEquals(companyDto.getName(), company.getName());
        assertEquals(companyDto.getCompanyCategory().getName(), company.getCompanyCategory().getName());
    }

    @Test
    @DisplayName("When a valid post is given, it should map the post to post DTO")
    public void postToDtoTest()
    {
        OffsetDateTime time = OffsetDateTime.now();

        Post post = new Post();
        post.setTitle("hi");
        post.setContent("asdfasdf");
        post.setCreatedAt(time);

        PostResponse expected = new PostResponse();
        expected.setTitle("hi");
        Mockito.when(postMapper.postToDto(Mockito.any())).thenReturn(expected);

        PostResponse postResponse = postMapper.postToDto(post);

        Assertions.assertEquals(expected.getTitle(), postResponse.getTitle());
    }
}
