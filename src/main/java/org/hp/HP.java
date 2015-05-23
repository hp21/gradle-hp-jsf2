package org.hp;

import java.io.InputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.ServletContext;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 * Created by U292148 on 2014.09.26..
 */
@ManagedBean(name = "hp")
public class HP implements Serializable {

    private static final DefaultStreamedContent DEFAULT_STREAMED_CONTENT = new DefaultStreamedContent();

    @ManagedProperty(value = "#{hp1}")
    private HP1 hp1;

    public HP() {
        System.out.println(this.getClass().toString() + " instantiated.");
    }

    public Double zzz() {
        return hp1.interestRate();
    }

    public String date() {
        return ISODateTimeFormat.dateTime().print(DateTime.now());
    }

    public void setHp1(HP1 hp1) {
        this.hp1 = hp1;
    }

    public StreamedContent getImage() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return DEFAULT_STREAMED_CONTENT;
        } else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            InputStream imageStream = ((ServletContext) context.getExternalContext().getContext()).getResourceAsStream("/images/cat.jpg");
            return new DefaultStreamedContent(imageStream);
        }
    }

}
