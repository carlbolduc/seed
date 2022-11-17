<#-- @ftlvariable name="" type="seed.views.PolicyView" -->
<#import "/libs/commons.ftl" as com>
<!DOCTYPE html>
<html lang="fr">
<@com.head title="${policy.titleFr} | Seed" description="${policy.descriptionFr}" />

<body>
<@com.header l="fr"/>
<main class="policy" itemprop="text">
    <h1>${policy.titleFr}</h1>
    <p style="font-style:italic;">Dernière mise à jour le ${lastUpdatedAt}</p>
    ${content?no_esc}
</main>
<@com.footer path="/policies/${policy.slug}" l="fr"/>
</body>

</html>