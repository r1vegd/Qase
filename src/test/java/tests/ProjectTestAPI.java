package tests;

import adapters.ProjectAdapter;
import models.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProjectTestAPI {

    @Test
    public void negativeApiTest() {
        Project project = Project.builder()
                .title("aqaaqa")
                .code("!!!")
                .build();
        ResponseStatus actual = new ProjectAdapter().post(project, 422);
        ResponseStatus expected = ResponseStatus.builder()
                .status(false)
                .errorMessage("Data is invalid.")
                .build();
        assertEquals(actual, expected);
        assertEquals(actual.isStatus(), expected.isStatus());
        assertEquals(actual.getErrorMessage(), expected.getErrorMessage());

    }


    @Test
    public void getProjectPositiveTestWithCases() {
        ResponseStatus actual = new ProjectAdapter().getProject(200, "DEMO");
//        System.out.println(actual);
        ResponseStatus expected =
                ResponseStatus.builder()
                        .status(true)
                        .result(
                                Result.builder()
                                        .title("Demo Project")
                                        .code("DEMO")
                                        .counts(Counts.builder()
                                                .cases(10)
                                                .suites(3)
                                                .milestones(2)
                                                .runs(Runs.builder()
                                                        .total(0)
                                                        .active(0)
                                                        .build())
                                                .defects(Defects.builder()
                                                        .total(0)
                                                        .open(0)
                                                        .build())
                                                .build())
                                        .build()
                        )
                        .build();
        assertEquals(actual, expected);
        assertEquals(actual.isStatus(), expected.isStatus());
    }

    @Test
    public void getProjectPositiveTestWithoutCases() {
        ResponseStatus actual = new ProjectAdapter().getProject(200, "QWERTY");
//        System.out.println(actual);
        ResponseStatus expected =
                ResponseStatus.builder()
                        .status(true)
                        .result(
                                Result.builder()
                                        .title("ForApiTestPositiveProject")
                                        .code("QWERTY")
                                        .counts(Counts.builder()
                                                .cases(0)
                                                .suites(0)
                                                .milestones(0)
                                                .runs(Runs.builder()
                                                        .total(0)
                                                        .active(0)
                                                        .build())
                                                .defects(Defects.builder()
                                                        .total(0)
                                                        .open(0)
                                                        .build())
                                                .build())
                                        .build()
                        )
                        .build();
        assertEquals(actual, expected);
        assertEquals(actual.isStatus(), expected.isStatus());
    }

    @Test
    public void getProjectNegativeTest() {
        ResponseStatus actual = new ProjectAdapter().getProject(404, "DEMO123");
        ResponseStatus expected = ResponseStatus.builder()
                .status(false)
                .errorMessage("Project is not found.")
                .build();
        assertEquals(actual, expected);
        assertEquals(actual.isStatus(), expected.isStatus());
        assertEquals(actual.getErrorMessage(), expected.getErrorMessage());
    }


}
