# Requirements

## Software Requirements

- **JDK 21.0 or later** – [Download from Adoptium](https://adoptium.net/){target="_blank"}
- **OpenAI API key** – provided by the workshop organizer
- **IDE with Java support** – IntelliJ, Eclipse, VSCode (with Java extension), etc.
- **Terminal** – to run commands
- _(Optional)_ **Git** – [Installation guide](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git){target="_blank"}

[//]: # (???+ note "Want to use our environment rather than yours?")

[//]: # (    If you are running this as part of an instructor-led workshop and have been provided a virtual machine, [click here]&#40;rhel-setup.md&#41; to learn about how to use it if you'd prefer it over using your own laptop.)


---

## AI Model Requirements

You will need an OpenAI API key to complete this workshop.  
If your instructor provided a key, use that one. Otherwise, [create an API key](https://platform.openai.com/docs/quickstart/create-and-export-an-api-key){target="_blank"}.

??? info "No instructor-provided key?"
    New OpenAI developer accounts receive $5 in free trial credits.  
    If you already used your credits, you’ll need to fund your account.
    
    !!! tip
        Don’t worry — this workshop is inexpensive. The total cost should not exceed **$0.50 (~€0.43)**.  
        See the [OpenAI pricing calculator](https://openai.com/api/pricing/){target="_blank"}.

Once you have a key, set it as an environment variable:

=== "Linux / macOS"
    ```bash
    export OPENAI_API_KEY=<your-key>
    ```

=== "Windows PowerShell"
    ```powershell
    $Env:OPENAI_API_KEY = <your-key>
    ```

---

## Good to Know

### Quarkus Dev Mode

Run your Quarkus app in **dev mode** from the project directory:

=== "Linux / macOS"
    ```bash
    ./mvnw quarkus:dev
    ```

=== "Windows"
    ```cmd
    mvnw quarkus:dev
    ```

Dev mode automatically recompiles your code on every change.
Your app will be available at http://localhost:8080/.

All data is stored in-memory, so restarting the application will reset the data to its initial state.

!!! warning "Switching steps"
    Stop the running application (Ctrl+C) before starting the next step.

### Debugging

To debug an app in dev mode, put breakpoints in your code and attach your IDE debugger.
In IntelliJ, use `Run > Attach to Process` and select the Quarkus process.
Other IDEs (Eclipse, VSCode) support similar remote debugging.

---

## Getting the Workshop Material

Either clone the repository with Git or download a ZIP archive.

### With Git

```bash
git clone https://github.com/mbroz2/jcon-europe-2026.git
cd jcon-europe-2026
```

### Direct Download

=== "Linux / macOS"
    ```bash
    curl -L -o workshop.zip https://github.com/mbroz2/jcon-europe-2026/archive/refs/heads/main.zip
    unzip workshop.zip
    cd jcon-europe-2026-main
    ```

=== "Windows PowerShell"
    ```powershell
    Invoke-WebRequest -Uri https://github.com/mbroz2/jcon-europe-2026/archive/refs/heads/main.zip -OutFile workshop.zip
    Expand-Archive workshop.zip -DestinationPath .
    cd jcon-europe-2026-main
    ```

---

## Optional: Pre-Warming Caches

This workshop requires downloading Maven dependencies.
To avoid bandwidth issues during the session, we recommend pre-downloading them.

### Warm up Maven

=== "Linux / macOS"
    ```bash
    ./mvnw verify
    ```

=== "Windows"
    ```cmd
    mvnw verify
    ```

!!! tip
    This command not only downloads dependencies but also verifies your setup before the workshop.

---

## Importing the Project in Your IDE

!!! tip
    Open the project from `step-01` in your IDE and use that directory throughout the workshop.

If you get stuck, simply switch to the `step-xx` directory that is after the the last step you completed.

---

## Next Step

Once ready, start with [Step 1 - Implementing AI Agents](./step-01.md).

