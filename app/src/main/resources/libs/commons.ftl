<#macro head title description>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="/assets/css/styles.css" media="screen"/>
        <title>${title}</title>
        <meta name="description" content="${description}" />
    </head>
</#macro>

<#macro header l>
    <header>
        <#if l == "fr">
            <a href="/?l=fr">Seed</a>
        <#else>
            <a href="/">Seed</a>
        </#if>
    </header>
</#macro>
<#macro footer path l>
    <footer id="footer">
        <#if l == "fr">
            <p class="tiny"><span class="bold">Compagnie :</span> <a href="/?l=fr">Accueil</a> - <a href="/posts?l=fr">Articles</a> - <a href="/about?l=fr">À propos</a></p>
            <p class="tiny"><span class="bold">Petits caractères :</span> <a href="/policies?l=fr">Conditions et confidentialité</a></p>
            <p class="tiny"><span class="bold">Langue:</span> <a href="${path}">English</a></p>
        <#else>
            <p class="tiny"><span class="bold">Company:</span> <a href="/">Home</a> - <a href="/posts">Posts</a> - <a href="/about">About us</a></p>
            <p class="tiny"><span class="bold">Fine print:</span> <a href="/policies">Terms & Privacy</a></p>
            <p class="tiny"><span class="bold">Language:</span> <a href="${path}?l=fr">Français</a></p>
        </#if>
    </footer>
</#macro>