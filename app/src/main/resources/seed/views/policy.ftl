<#-- @ftlvariable name="" type="seed.views.PolicyView" -->
<#import "/libs/commons.ftl" as com>
<!DOCTYPE html>
<html lang="en">
<@com.head title="${policy.titleEn} | Seed" description="${policy.descriptionEn}" />

<body>
<@com.header l="en"/>
<main class="policy" itemprop="text">
    <h1>${policy.titleEn}</h1>
    <p style="font-style:italic;">Last updated on ${lastUpdatedAt}</p>
    ${content?no_esc}
</main>
<@com.footer path="/policies/${policy.slug}" l="en"/>
</body>

</html>