import opstree.common.StaticCodeAnalysis

def call(Map config = [:]) {
    def scan = new StaticCodeAnalysis(this)
    scan.execute(config)
}
