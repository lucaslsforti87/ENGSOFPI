package util;

import java.io.Serializable;
import java.time.LocalDate;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.date.DateViewChangeEvent;
import org.primefaces.model.datepicker.DateMetadataModel;
import org.primefaces.model.datepicker.DefaultDateMetadata;
import org.primefaces.model.datepicker.DefaultDateMetadataModel;
import org.primefaces.model.datepicker.LazyDateMetadataModel;


@Named
@ViewScoped
public class DatePickerMetadataView implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate date2;
    private final DateMetadataModel model;
    private final DateMetadataModel modelLazy;

    public DatePickerMetadataView() {
        LocalDate start = LocalDate.now().withDayOfMonth(1);
        DefaultDateMetadata metadataDisabled = DefaultDateMetadata.builder().disabled(true).build();
        DefaultDateMetadata metadataStart = DefaultDateMetadata.builder().styleClass("start").build();
        DefaultDateMetadata metadataDeadline = DefaultDateMetadata.builder().styleClass("deadline").build();

        model = new DefaultDateMetadataModel();
        model.add(start.minusMonths(1), metadataDisabled);
        model.add(start.plusMonths(3), metadataStart);
        model.add(start.plusMonths(6), metadataDisabled);
        model.add(start.plusMonths(9), metadataDeadline);
        model.add(start.plusMonths(1), metadataDisabled);

        modelLazy = new LazyDateMetadataModel() {
            @Override
            public void loadDateMetadata(LocalDate start, LocalDate end) {
                add(start.plusMonths(2), metadataStart);
                add(start.plusMonths(5), metadataDisabled);
                add(start.plusMonths(8), metadataDeadline);
            }
        };
    }

    public void onViewChange(DateViewChangeEvent event) {
        String summary = "Year: " + event.getYear() + ", month: " + event.getMonth();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    // Getters and setters

    public LocalDate getDate2() {
        return date2;
    }

    public void setDate2(LocalDate date2) {
        this.date2 = date2;
    }

    public DateMetadataModel getModel() {
        return model;
    }

    public DateMetadataModel getModelLazy() {
        return modelLazy;
    }
}
