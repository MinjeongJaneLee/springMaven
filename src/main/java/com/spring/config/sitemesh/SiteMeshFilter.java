package com.spring.config.sitemesh;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.Sm2TagRuleBundle;

/**
 * SiteMesh 설정 클래스 이다.
 * <ul>
 *     <li>SiteMeshFilterBuilder 설정</li>
 * </ul>
 */
public class SiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addTagRuleBundle(new Sm2TagRuleBundle());
        builder.addExcludedPath("*.html");
        builder.addExcludedPath("*.ajax");
        builder.addDecoratorPath("/*", "/WEB-INF/views/layout/default/base.jsp");
        builder.addDecoratorPath("/**/*.popup", "/WEB-INF/views/layout/default/popup.jsp");
        builder.addDecoratorPath("/common/login/login.do", "/WEB-INF/views/layout/login/base.jsp");
    }
}
