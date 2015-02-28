package com.sbk.algo.client.view.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.sbk.core.client.gin.CoreInjector;
import com.sbk.core.client.resources.CoreResources;

/**
 * Created by sobik on 27/02/2015.
 */
public class LoginPanel extends Composite {

    private static LoginPanelUiBinder uiBinder = GWT.create(LoginPanelUiBinder.class);
    CoreResources resources = CoreInjector.INSTANCE.getCoreResources();

    public LoginPanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiTemplate("LoginPanel.ui.xml")
    interface LoginPanelUiBinder extends UiBinder<Widget, LoginPanel> {
    }
}
