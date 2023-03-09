package com.solvd.laba.apihomework;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.laba.carina.demo.api.comments.GetCommentsMethods;
import com.solvd.laba.carina.demo.api.comments.PatchCommentsMethods;
import com.solvd.laba.carina.demo.api.comments.PostCommentsMethods;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class CommentsTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetComments() {
        LOGGER.info("TEST GET COMMENT");
        GetCommentsMethods getCommentsMethods = new GetCommentsMethods();
        getCommentsMethods.callAPIExpectSuccess();
        getCommentsMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getCommentsMethods.validateResponseAgainstSchema("api/comments/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateComments() throws Exception {
        LOGGER.info("TEST POST COMMENT");
        PostCommentsMethods api = new PostCommentsMethods();
        api.callAPIExpectSuccess();
        api.validateResponse();
        api.validateResponseAgainstSchema("api/comments/_post/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateCommentsMissingSomeFields() throws Exception {
        LOGGER.info("TEST POST MISSING FIELDS COMMENT");
        PostCommentsMethods api = new PostCommentsMethods();
        api.getProperties().remove("name");
        api.getProperties().remove("postId");
        api.callAPIExpectSuccess();
        api.validateResponse();
        api.validateResponseAgainstSchema("api/comments/_post/rs.schema");
    }

    @Test
    public void testPatchComments() {
        LOGGER.info("TEST PATCH COMMENT");
        PostCommentsMethods api = new PostCommentsMethods();
        Response r = api.callAPIExpectSuccess();
        api.validateResponse();
        PatchCommentsMethods api2 = new PatchCommentsMethods();
        api2.replaceUrlPlaceholder("id", Integer.toString(r.jsonPath().getInt("id")));
        api2.callAPIExpectSuccess();
        api.validateResponse();
    }

}
