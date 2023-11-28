import Link from "next/link";

export default function Home() {
  return (
      <div className="flex flex-col p-10 justify-center h-screen">
          <div className="prose lg:prose-xl py-2 mb-5">
              <h1>Blogging App</h1>
          </div>
          <div className="container flex grow justify-center items-center">
              <button className="btn btn-lg btn-primary">
                  <Link href="/articles">Start Blogging</Link>
              </button>
          </div>
      </div>
  )
}
