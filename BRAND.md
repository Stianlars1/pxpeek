# PxPeek — Brand Guide

A pocket-sized reference for how PxPeek looks, sounds, and shows up in the world.

---

## 1. Essence

**Name:** PxPeek
**Pronunciation:** "pix-peek"
**Category:** JetBrains IDE plugin. CSS inlay hint tool.
**One-liner:** *See the pixels behind your units.*

### Punchline candidates (pick one per surface)
- **Primary — Marketplace tagline:** *See the pixels behind your units.*
- Short — social/README hero: *rem, solved.*
- Wordy — long-form: *Inline pixel equivalents for every CSS unit, quietly, while you type.*
- Nerdy — for devlogs: *Your stylesheet's silent translator.*

### Elevator pitch (≤25 words)
> PxPeek shows the pixel value of every `rem`, `em`, `vh`, `%`, and friend as an inline hint. No pop-ups, no plugins to toggle, no math.

---

## 2. Voice & tone

| Attribute | We are | We are not |
|---|---|---|
| Register | Calm, confident, understated | Hypey, exclamation-heavy |
| Humor | Dry, occasional wink | Goofy, meme-forward |
| Authority | Quietly expert | Lecturing |
| Audience | Front-end devs who care about craft | Absolute beginners |

**Rule of thumb:** if a sentence would feel at home in an Apple product note, it fits. If it would fit on a banner ad, rewrite it.

### Copy "yes / no"
- ✅ "Pixels, without the mental math."
- ✅ "It reads your CSS. You keep writing."
- ❌ "🚀 Supercharge your CSS workflow NOW!!"
- ❌ "The ultimate CSS plugin you've been waiting for."

---

## 3. Logo direction

PxPeek doesn't need a mascot or ornate icon. The name already carries the idea — *peek* through a lens, at a pixel.

### Three viable directions (in order of preference)

1. **The Peek Eye** *(recommended)*
   A rounded square containing two stacked pixels forming a minimalist eye: a flat horizontal "eyelid" bar over a single square "pupil". Reads as both a pixel grid and an eye peering out. Monochrome, works at 16×16.

2. **The Px Monogram**
   A tight ligature of `px` where the `p`'s counter and the `x`'s crossing point share the same pixel-sized square. Plays on the name without being literal.

3. **The Unit Ruler**
   A tiny horizontal ruler with two tick marks — one labeled `rem`, one labeled `px` — connected by a bracket. Functional, informative, but more illustration than mark.

### Logo rules
- **Grid:** design on a 24×24 base grid. All strokes snap to whole pixels at 1×.
- **Corner radius:** 4px on a 24px canvas (keep it friendly, not sharp).
- **Weight:** single stroke width throughout. No dual weights.
- **Clearspace:** minimum padding equal to the height of the "pupil" square.
- **Minimum size:** 16×16 (tool-window icon), 13×13 (IntelliJ plugin list).
- **Do not:** gradient it, add shadow, rotate, stretch, color-fill, place over photography.

### Required icon deliverables for the JetBrains Marketplace
- `pluginIcon.svg` — 40×40 viewBox, light-theme color
- `pluginIcon_dark.svg` — same mark, dark-theme adjusted
- Embed in `src/main/resources/META-INF/`

---

## 4. Wordmark & type

- **Wordmark:** always written `PxPeek` — camelCase with a capital P on both halves. Never `PXPeek`, `pxpeek` (directory / id only), or `Px Peek`.
- **When to use lowercase `pxpeek`:** code, package paths, plugin id, CLI-ish contexts only.
- **Primary typeface:** Inter (400/600) for UI and long copy.
- **Display typeface (logo, hero):** JetBrains Mono or Berkeley Mono — the monospace lean reinforces the code-editor heritage.
- **Never use:** Comic Sans, Papyrus, script faces, ultra-compressed fonts. The brand is a quiet tool, not a nightclub flyer.

---

## 5. Color palette

Keep it minimal — one accent, one utility, two neutrals.

| Role | Name | Hex | Use |
|---|---|---|---|
| Primary | *Peek Ink* | `#111111` | Mark, headlines on light |
| Primary inverse | *Paper* | `#F5F5F5` | Mark, headlines on dark |
| Accent | *Px Cyan* | `#4EC9B0` | Hover, link, inline hint echo (matches VS Code / JetBrains default comment teal) |
| Neutral | *Gutter Grey* | `#6E7681` | Body, secondary text |
| Surface | *Editor Night* | `#1E1E1E` | Dark-mode backdrops in marketing shots |

**Never** use a warning-red or alert-orange in marketing — the plugin is passive, ambient. Loud colors betray the vibe.

---

## 6. Imagery & screenshots

Every marketing/README screenshot should:
- Use a real `.css`/`.scss` snippet with 3–6 lines of realistic, legible code
- Include **at least three different units** in the same shot (`rem`, `vh`, `%`) — that's the product
- Render in a dark theme (Darcula or One Dark) — this is where inlays look best
- Be cropped tight: line numbers visible on the left, no chrome/titlebars
- Avoid cursor artifacts, selection highlights, and error squiggles

---

## 7. Ready-to-paste copy

### JetBrains Marketplace — short description (≤120 chars)
> See the pixels behind your units. Inline `rem`, `em`, `%`, `vh`, `vw` → px hints for CSS, SCSS, Sass, LESS.

### Long description (Marketplace "Overview")
> PxPeek answers the one question that slows every CSS read: *how big is that, actually?*
>
> It shows the pixel equivalent of every relative unit as an inline comment-style hint — `42rem` becomes `42rem /* 672px */`. The hints live in the editor only; your file is never touched.
>
> Works in any JetBrains IDE that ships CSS support (WebStorm, IntelliJ IDEA Ultimate, PhpStorm, PyCharm Pro, RubyMine, GoLand, RustRover) across `.css`, `.scss`, `.sass`, `.less`, and CSS modules.
>
> **Supports:** rem, em, %, pt, pc, in, cm, mm, Q, ch, ex, vw, vh, vmin, vmax, and the small/large/dynamic viewport variants (svw, lvw, dvw, svh, lvh, dvh).
>
> Toggle anytime: *Settings → Editor → Inlay Hints → Values → Pixel equivalents.*

### README hero section
```
# PxPeek

See the pixels behind your units.

[screenshot]

PxPeek adds inline pixel-equivalent hints to every relative CSS
unit in your editor. No popups. No docs panel. No Cmd+click.
Just the number you wanted, where you were already looking.
```

### Social launch post (LinkedIn / X, 1 post)
> Shipped a tiny JetBrains plugin I've wanted for years: PxPeek.
>
> It turns every `42rem` into `42rem /* 672px */` as an inline hint. Nothing written to your file — it's purely an editor overlay. Works in WebStorm, IntelliJ, PhpStorm, every IDE with the CSS plugin.
>
> Free. Open. Link ↓

### Marketplace "What's new" entries (tone reference)
- `0.1.0 — First release. rem/em/%/vh/vw and 12 other units, across CSS/SCSS/Sass/LESS.`
- Keep entries under 90 chars, factual, no emojis, no "we're excited to announce".

---

## 8. Distribution checklist

### JetBrains Marketplace (primary channel)
1. Create a free account at https://plugins.jetbrains.com/
2. Upload `build/distributions/pxpeek-0.1.0.zip` via *Upload plugin*
3. Fill out:
   - **Short description** — see §7
   - **Long description** — see §7
   - **Tags** — `css`, `scss`, `sass`, `less`, `inlay hints`, `front-end`
   - **Category** — `Code tools`
   - **License** — MIT (recommend) or Apache-2.0
   - **Vendor info** — name, site, support email
4. Upload `pluginIcon.svg` and `pluginIcon_dark.svg`
5. Upload 2–4 screenshots (see §6)
6. Submit for review. First review typically 1–3 business days.

### Plugin signing (optional, recommended)
JetBrains supports signing plugins for Marketplace trust. Use the Gradle plugin's `signPlugin` task with a certificate generated via `./gradlew generateIntellijPlatformPluginVerificationCertificate` — follow the official signing guide on plugins.jetbrains.com/docs.

### Secondary distribution
- **GitHub Releases:** attach the zip, tag `v0.1.0`. Serves as mirror + source-of-truth for changelog.
- **A short landing page:** pxpeek.dev (or similar) with one screenshot, one paragraph, two buttons: *Install* → Marketplace URL, *Source* → GitHub URL. Nothing more.
- **Dev communities:** r/webdev, r/Jetbrains, Hacker News *Show HN*, dev.to. Post once, answer comments, don't cross-post aggressively.

### Versioning
Semver. Patch for bug fixes, minor for new units or surfaces, major for breaking UX (e.g. removing default-on behavior). Keep `untilBuild` open (null) so compatibility doesn't expire on each IDE release.

---

## 9. Non-goals (keep the brand honest)

PxPeek will never:
- Modify your CSS file
- Show color swatches or variable chains (other plugins do this better — `css-vars-assistant`, stock JetBrains)
- Convert units on demand ("refactor rem → px") — that's a different product
- Add settings panels for things with a sensible default

**Why this matters for the brand:** the restraint *is* the product. Every feature we decline is a reason someone installs the plugin and forgets it's installed — which is the highest compliment this kind of tool can earn.
