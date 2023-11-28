import Link from "next/link";
import Head from "next/head";

// type Article = {
//     id: number
//     author: string
//     title: string
//     content: string
//     timestamp: string
// }

export default function ArticleList({ articleList }) {
    return (
        <div className="p-10 justify-center">
            <Head>
                <title>All Articles</title>
            </Head>
            <div className="prose lg:prose-xl py-2 mb-5">
                <h1>All Articles</h1>
            </div>
            <div className="container glass xl:rounded-box p-10 w-7/12">
                <button className="form-control flex flex-row w-full justify-center">
                    <Link href="/articles/create" className="flex w-3/4">
                        <div className="input-group">
                            <input type="text" placeholder="Write something..." className="input input-bordered w-full"/>
                            <div className="btn">Start Writing</div>
                        </div>
                    </Link>
                </button>
                {articleList.map(article => (
                    <div className="card bg-base-100 shadow-xl mx-auto my-5 w-3/4" key={article.id}>
                        <div className="card-body">
                            <h2 className="card-title">
                                {article.title}
                                <div className="badge badge-secondary">{article.author}</div>
                            </h2>
                            <p className="line-clamp-4">{article.content}</p>
                            <div className="card-actions justify-between items-end">
                                <h5 className="text-xs opacity-50">{article.timestamp}</h5>
                                <a className="btn btn-primary" href={`articles/${article.id}`}>See Post</a>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    )
}

export async function getServerSideProps() {
    const result = await fetch("http://localhost:8080/api/v1/article/get-all-posts", {
        cache: "no-store",
    })
    const data = await result.json()

    return {
        props: { articleList: data },
    }
}