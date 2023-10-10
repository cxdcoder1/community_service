package com.example.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.community.entity.ZyComment;
import org.apache.ibatis.annotations.Param;

/**
 * 评论表(ZyComment)表服务接口
 *
 * @author makejava
 * @since 2023-09-14 09:53:03
 */
public interface ZyCommentService extends IService<ZyComment> {


    int updDelFlag(String id);

}

