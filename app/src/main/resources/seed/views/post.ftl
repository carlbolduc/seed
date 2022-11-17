<#-- @ftlvariable name="" type="seed.views.PostView" -->
<#import "/libs/commons.ftl" as com>
<!DOCTYPE html>
<html lang="en">

<@com.head title="${post.titleEn} | Seed" description="${post.descriptionEn}" />

<body>
<@com.header l="en"/>

<main class="blog-post" itemprop="text">
    <h1>${post.titleEn}</h1>
    <p style="font-style:italic;">Published on ${formattedPublishedOn}</p>
    ${content?no_esc}
</main>

<@com.footer path="/post/${post.slug}" l="en"/>
</body>

</html>