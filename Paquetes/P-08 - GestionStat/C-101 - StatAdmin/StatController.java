package com.eleven.views;

import com.eleven.controller.EMatchFacade;
import com.eleven.model.EMatch;
import com.eleven.model.Stat;
import com.eleven.model.Team;
import com.eleven.views.util.JsfUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("statController")
@ViewScoped
public class StatController implements Serializable {

    @EJB
    private com.eleven.controller.EMatchFacade ejbFacade;
    @EJB
    private com.eleven.controller.TeamFacade ejbFacade2;
    private List<EMatch> matches = null;
    private List<Stat> items = null;
    private EMatch selected;

    public StatController() {
    }

    public EMatch getSelected() {
        return selected;
    }

    public void setSelected(EMatch selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EMatchFacade getFacade() {
        return ejbFacade;
    }

    public EMatch prepareCreate() {
        selected = new EMatch();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(JsfUtil.PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EMatchCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(JsfUtil.PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EMatchUpdated"));
    }

    public void destroy() {
        persist(JsfUtil.PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EMatchDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EMatch> getMatches() {
        if (matches == null) {
            matches = getFacade().findAll();
        }
        return matches;
    }
    
     public void buildItems() {
   
            items = new ArrayList();
         
            List<Team> teams = ejbFacade2.findAll();
         
            for(Team team : teams) {
            
                Stat stat = new Stat(team);
                
                items.add(stat);
                
            }
            
            for(EMatch ematch : matches) {
                
                Team team1 = ematch.getTeam1();
                Team team2 = ematch.getTeam2();
                
                switch ((int)ematch.getWinnerTeam()) {
                     
                     case 0:
                         
                    setResult(team1, 0);
                    setResult(team2, 0);
                    break;
                    
                     case 1:
                         
                    setResult(team1, 1);
                    setResult(team2, 2);
                    break;
                 
                     case 2:
                         
                    setResult(team1, 2);
                    setResult(team2, 1);
                     break;
                    
                }
                
            }
       
    }
     
    private void setResult(Team team, int result) {
        
        for(int i = 0; i < items.size(); i++) {
           
            if(items.get(i).getTeam().equals(team)) {
                
                switch (result) {
                    
                    case 0:
                    
                    items.get(i).addDraw();
                     break;
                     
                    case 1:
                    
                    items.get(i).addWin();
                     break;
                     
                    case 2:
                    
                    items.get(i).addLose();
                     break;
                     
                }
                
                break;
                
            }
            
        }
        
    }
    
    public List<Stat> getItems() {
          
            getMatches();
            
            buildItems();
           
        
        return items;
        
    }

    private void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != JsfUtil.PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public EMatch getEMatch(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<EMatch> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EMatch> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EMatch.class)
    public static class EMatchControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EMatchController controller = (EMatchController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "eMatchController");
            return controller.getEMatch(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EMatch) {
                EMatch o = (EMatch) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EMatch.class.getName()});
                return null;
            }
        }

    }

}
