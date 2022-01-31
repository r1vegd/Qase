package adapters;

import models.Project;
import models.ResponseStatus;


public class ProjectAdapter extends BaseAdapter {

    public ResponseStatus post(Project project, int statusCode) {
        String response = post(gson.toJson(project), statusCode, "project");
        return gson.fromJson(response, ResponseStatus.class);
    }

    public ResponseStatus getProject(int statusCode, String codeProject) {
        String response = super.get(statusCode, "project/" + codeProject);
        return gson.fromJson(response, ResponseStatus.class);
    }

}


