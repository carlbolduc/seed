<#-- @ftlvariable name="" type="seed.views.PoliciesView" -->
<#import "/libs/commons.ftl" as com>
<!DOCTYPE html>
<html lang="en">
<@com.head title="Our Policies, Terms, and Legal Stuff | Seed" description="All the policies and legal stuff for Seed." />
<body>
<@com.header l="en"/>
<main>
    <h1>Our Policies, Terms, and Legal Stuff</h1>
    <p>The rough print and the fine print. We try to make all our policies as clear, fair, and readable as possible.</p>
    <ul>
        <#list policies as policy>
            <li><a href="/policies/${policy.slug}">${policy.titleEn}</a></li>
        </#list>
    </ul>
</main>
<@com.footer path="/policies" l="en"/>
</body>

</html>