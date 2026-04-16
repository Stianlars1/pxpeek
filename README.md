# PxPeek

**See the pixels behind your units.**

A JetBrains IDE plugin that shows the pixel equivalent of every relative CSS unit as an inline, comment-style inlay hint.

```css
.button {
  width: 42rem;       /* 672px */
  padding: 1rem 2rem; /* 16px 32px */
  height: 50vh;       /* 450px */
  font-size: 120%;    /* 19.2px */
}
```

The hints live in the editor only — your file is never modified.

## Install

**From JetBrains Marketplace** (when published):
*Settings → Plugins → Marketplace → search "PxPeek"*

**From disk:**
1. Download the latest `pxpeek-x.y.z.zip` from [Releases](https://github.com/Stianlars1/pxpeek/releases)
2. *Settings → Plugins → ⚙ → Install Plugin from Disk…*

## Supported units

`rem`, `em`, `%`, `pt`, `pc`, `in`, `cm`, `mm`, `Q`, `ch`, `ex`, `vw`, `vh`, `vmin`, `vmax`, plus the small/large/dynamic viewport variants (`svw`, `lvw`, `dvw`, `svh`, `lvh`, `dvh`).

`px` values are skipped — they'd be redundant.

## Supported file types

`.css`, `.scss`, `.sass`, `.less` — including CSS modules (`*.module.css`).

## Supported IDEs

Any JetBrains IDE that ships the bundled CSS plugin: **WebStorm, IntelliJ IDEA Ultimate, PhpStorm, PyCharm Professional, RubyMine, GoLand, RustRover, Aqua**.

Requires build **251** (2025.1) or newer.

## Hint placement

Choose where hints appear: *Settings → Editor → Inlay Hints → PxPeek*

| Mode | Example |
|---|---|
| **End of line** (default) | `width: min(42rem, 100%); /* 672px, 16px */` |
| **Inline** | `width: min(42rem /* 672px */, 100% /* 16px */)` |

## Conversion defaults

Hardcoded (no settings panel needed):

| Unit family | Basis |
|---|---|
| `rem`, `em` | 16 px root font |
| `%` | 16 px (font-size context) |
| `vw` / viewport-width variants | 1440 px |
| `vh` / viewport-height variants | 900 px |

Toggle PxPeek on/off per language: *Settings → Editor → Inlay Hints → Values → Pixel equivalents*.

## Build from source

```sh
./gradlew buildPlugin       # produces build/distributions/pxpeek-x.y.z.zip
./gradlew runIde            # launches a sandbox IDE with the plugin loaded
./gradlew verifyPlugin      # validates plugin structure
```

Requires JDK 21, Gradle 8.13+ (wrapper included).

## License

MIT — see [LICENSE](./LICENSE).
