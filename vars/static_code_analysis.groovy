import opstree.common.StaticCodeAnalysis

def call(Map config = [:]) {
    new StaticCodeAnalysis(this).execute(config)
}
