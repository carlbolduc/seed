<#-- @ftlvariable name="" type="seed.views.PostsView" -->
<#import "/libs/commons.ftl" as com>
<!DOCTYPE html>
<html lang="en">
<@com.head title="Posts | Seed" description="" />
<body>
<@com.header l="en"/>

<main>
    <h1>Posts</h1>
    <div>
        <ul>
            <#list posts as post>
                <li><a href="/posts/${post.slug}/">${post.listPublishedOn} - ${post.titleEn}</a></li>
            </#list>
        </ul>
    </div>
</main>
<@com.footer path="/posts" l="en"/>
</body>

</html>