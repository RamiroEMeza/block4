package com.solvd.laba.carina.demo.api.comments;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.env.api_url}/comments", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/comments/_post/rq.json")
@ResponseTemplatePath(path = "api/comments/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostCommentsMethods extends AbstractApiMethodV2 {
    public PostCommentsMethods() {
        setProperties("api/comments/comments.properties");
    }
}
