<#-- @ftlvariable name="" type="seed.views.PostsView" -->
<#import "/libs/commons.ftl" as com>
<!DOCTYPE html>
<html lang="fr">
<@com.head title="Articles | Seed" description="" />
<body>
<@com.header l="fr"/>

<main>
    <h1>Articles</h1>
    <div>
        <ul>
            <#list posts as post>
                <li><a href="/posts/${post.slug}?l=fr">${post.listPublishedOn} - ${post.titleFr}</a></li>
            </#list>
        </ul>

    </div>
</main>
<@com.footer path="/posts" l="fr"/>
</body>

</html>