title="FAQ"
description="Frequently Asked Questions about raw.githack.com service"
multiline content << 'HTML'

<p class="hero">
  <strong>FAQ</strong>
</p>

<div>
  <div id="who" class="question">
    <h2><a href="#who">Who runs this thing?</a></h2>
    <p>
      Hi, I'm <a href="https://github.com/neoascetic">Pavel Puchkin</a>.
    </p>
  </div>

  <div id="why" class="question">
    <h2><a href="#why">Why is this necessary? Can't I just load files from my favorite service directly?</a></h2>
    <p>
      When you request a file from source control hosting services, they are usually served (in the case of JavaScript, HTML, CSS, and some other file types) with a <code>Content-Type</code> of <code>text/plain</code>. As a result, most modern browsers won't actually interpret it as JavaScript, HTML, or CSS.
    </p>
    <p>
      They do this because serving raw files from a git repo is relatively inefficient, so they want to discourage people from using their repos for static file hosting.
    </p>
    <p>
      raw.githack.com acts as a caching proxy, forwarding requests to the corresponding service, caching the responses either for a short time (in the case of development URLs) or permanently (in the case of CDN URLs), and relaying them to your browser with the correct <code>Content-Type</code> headers.
    </p>
    <p>
      The caching layer ensures that minimal load is placed on each service, and you get quick and easy static file hosting right from a repo. Everyone's happy!
    </p>
  </div>

  <div id="what-is-supported" class="question">
    <h2><a href="#what-is-supported">What source code services are supported?</a></h2>
    <p>
      Currently, the following services are supported:
    </p>
    <ul>
      <li><a href="https://github.com/">GitHub</a> (with <a href="https://gist.github.com/">Gist</a>)</li>
      <li><a href="https://bitbucket.org/">Bitbucket</a></li>
      <li><a href="https://gitlab.com/">GitLab</a></li>
      <li><a href="https://gitea.com/">Gitea</a></li>
      <li><a href="https://codeberg.org/">Codeberg</a></li>
    </ul>
  </div>

  <div id="associated-with-hosting-service" class="question">
    <h2><a href="#associated-with-hosting-service">Is raw.githack.com associated with any of the supported hosting services?</a></h2>
    <p>
      No, raw.githack.com is not associated with them in any way. Please don't contact their support asking for help with raw.githack.com. They'll give you a weird look and back away slowly.
    </p>
  </div>

  <div id="diff-between-rawgithack-and-cdn" class="question">
    <h2><a href="#diff-between-rawgithack-and-cdn">What's the difference between development and CDN URLs?</a></h2>
    <p>
      When you make a request to a development URL, the server loads the requested file from the corresponding service, serves it to your browser with the correct <code>Content-Type</code> header, and caches it for a short time. If you push new changes to your repo, you can reload and see them within a few minutes, which makes development URLs useful for low-traffic testing or sharing demos during development.
    </p>
    <p>
      Requests to CDN are routed through <a href="http://cloudflare.com/">CloudFlare</a>'s content delivery network, and are cached <strong>for an year</strong> the first time they're loaded. This results in the best performance and reduces load on raw.githack.com and on underlying service, but it means that reloading won't fetch new changes. Furthermore, JS, CSS and HTML files can be minified for the sake of performance, if you add <code>?min=1</code> query parameter.
    </p>
    <p>
      During development, when traffic is low and freshness is more important than performance, use development URLs. For anything you share with the public or push to production, use CDN URLs.
    </p>
  </div>

  <div id="development-in-production" class="question">
    <h2><a href="#development-in-production">Can I use a development URL on a production website?</a></h2>
    <p>
      Better no. Please use CDN URLs for anything that might result in heavy traffic. Only use development URLs for low-traffic testing and sharing temporary examples or demos during development. 
    </p>
    <p>
      If you don't and the service gets a lots of requests from the same domain, all further requests will be temporary redirected to corresponding CDN URLs, meaning some clients won't see changes you push to your repo on the next request.
    </p>
  </div>

  <div id="cdn-ttl" class="question">
    <h2><a href="#cdn-ttl">How long does the CDN cache files? How can I make it refresh my file?</a></h2>
    <p>
      The CDN caches files for one year based on their path. It ignores query strings. This is done both to improve performance and to make it possible for the CDN to handle massive amounts of traffic without causing excessive load on the underlying services.
    </p>
    <p>
      To ensure that the CDN always serves the version of the file you want, use a git tag or commit ref in the file's path instead of a branch name, and update the URL if you push a new version of the file.
    </p>
    <p>
      So, instead of a URL like <code>/user/repo/BRANCH/file</code>, use a URL like <code>/user/repo/TAG/file</code> or <code>/user/repo/COMMIT/file</code>.
    </p>
  </div>

  <div id="no-uptime-guarantee" class="question">
    <h2><a href="#no-uptime-guarantee">I need guaranteed 100% uptime. Should I use raw.githack.com?</a></h2>
    <p>
      Probably not.
    </p>
    <p>
      raw.githack.com is a free service and cannot provide any uptime or support guarantees, even for CDN URLs. While I do my best to keep things running, things sometimes go wrong. Sometimes there are network or provider issues outside my control, sometimes abusive traffic temporarily affects response times, and sometimes I break things (although I try really hard not to).
    </p>
    <p>
      You can take a look at our <a href="https://status.githack.com/?r=neoascetic/raw.githack.com-monitor">uptime stats</a> to decide if this service is stable enough for you. On the other hand, the service has been working since 2013, for more than a decade, without major outages. Doesn't this mean something?
    </p>
  </div>

  <div id="sponsorship" class="question">
    <h2><a href="#sponsorship">I would like to support this service, how can I do this?</a></h2>
    <p>
      You can consider becoming a patreon through our <a href="https://www.patreon.com/rawgithackcom">Patreon</a> page. Every patron gets free unlimited access to the <a href="/purge-cache">cache invalidation</a>.
    </p>
    <p>
      You also can use referal links to register an account with one of our partners:
    </p>
    <ul>
      <li><a href="https://hetzner.cloud/?ref=BrRJMValwaz8">Hetzner</a>. Hetzner Online, with hundreds of thousands of servers in operation, is one of the largest data center operators in Europe.</li>
    </ul>
    <p>
      Thank you!
    </p>
  </div>

  <div id="feedback" class="question">
    <h2><a href="#feedback">I have feedback or want to report a bug! Who can I contact?</a></h2>
    <p>
      To report a critical issue like raw.githack.com being broken, used to spread spam/copyright-protected content/etc or to share general feedback, <a href="mailto:admin@githack.com">send me a letter</a>. I try to respond quickly when I'm awake and near a computer, but sometimes I do have to sleep. To report a non-critical bug, please <a href="https://github.com/neoascetic/rawgithack/issues">file an issue</a>.
    </p>
  </div>

  <div id="purge" class="question">
    <h2><a href="#purge">Can I somehow purge cached URLs?</a></h2>
    <p>
      If you messed up and want your cache to be purged, you can do this <a href="/purge-cache">using special form</a>.
    </p>
  </div>

</div>

HTML
