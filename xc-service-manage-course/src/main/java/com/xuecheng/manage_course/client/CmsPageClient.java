package com.xuecheng.manage_course.client;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.domain.cms.response.CmsPostPageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author wzg
 * @Date 2020/8/28
 * @Version 1.0
 */
@FeignClient(value = "XC-SERVICE-MANAGE-CMS")
public interface CmsPageClient {
    //根据页面id查询页面信息，feign远程调用cms
    @GetMapping("/cms/page/get/{id}")
    public CmsPage findCmsPageByID(@PathVariable("id") String id);
    //添加页面，用于课程预览
    @PostMapping("/cms/page/save")
    public CmsPageResult saveCmsPage(@RequestBody CmsPage cmsPage);
    //一键发布页面
    @PostMapping("/cms/page/postPageQuick")
    public CmsPostPageResult postPageQuick(@RequestBody CmsPage cmsPage);

}
