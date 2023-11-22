package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.DateViewChangeEvent;

public class MessageUtil {
	public static void sucesso(String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
	}
	public static void erro(String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
	}
	
	public void onViewChange(DateViewChangeEvent event) {
        String summary = "Year: " + event.getYear() + ", month: " + event.getMonth();
        MessageUtil.sucesso(summary, null);
    }
}
