<#-- @ftlvariable name="" type="seed.views.PostView" -->
<#import "/libs/commons.ftl" as com>
<!DOCTYPE html>
<html lang="fr">

<@com.head title="${post.titleFr} | Seed" description="${post.descriptionFr}" />

<body>
<@com.header l="fr"/>

<main>
    <h1>${post.titleFr}</h1>
    <p style="font-style:italic;">Publié le ${formattedPublishedOn}</p>
    ${content?no_esc}
</main>

<@com.footer path="/posts/${post.slug}" l="fr"/>
</body>

</html>