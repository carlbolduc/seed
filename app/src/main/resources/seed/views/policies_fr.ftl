<#-- @ftlvariable name="" type="seed.views.PoliciesView" -->
<#import "/libs/commons.ftl" as com>
<!DOCTYPE html>
<html lang="fr">
<@com.head title="Nos politiques, conditions et trucs légaux | Seed" description="Toutes les politiques et les trucs légaux pour Seed." />
<body>
<@com.header l="fr"/>
<main>
    <h1>Nos politiques, conditions et trucs légaux</h1>
    <p>Les gros caractères et les petits caractères. Nous nous efforçons de rendre toutes nos politiques aussi claires, équitables et lisibles que possible.</p>
    <ul>
        <#list policies as policy>
            <li><a href="/policies/${policy.slug}?l=fr">${policy.titleFr}</a></li>
        </#list>
    </ul>
</main>
<@com.footer path="/policies" l="fr"/>
</body>

</html>