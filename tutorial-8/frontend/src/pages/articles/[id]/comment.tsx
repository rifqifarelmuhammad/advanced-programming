import Head from "next/head";
import Link from "next/link";
import {useRouter} from "next/router";
import {SyntheticEvent, useState} from "react";

export default function CreateComment({ article }) {
    const router = useRouter()
    const [author, setAuthor] = useState("")
    const [content, setContent] = useState("")
    const [isMutating, setIsMutating] = useState(false)

    async function handleSubmit(e: SyntheticEvent) {
        e.preventDefault()
        setIsMutating(true)

        await fetch(`http://localhost:8081/api/v1/comment/create-comment/${article.id}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                author: author,
                content: content
            })
        }).then(async (response) => {
        console.log(
            JSON.stringify({
                author: author,
                content: content
            })
        )

        router.push(`/articles/${article.id}`)
        }).catch((e) => {
            alert("Failed to comment")
            console.log(e)
        }).finally(() => {
            setIsMutating(false)
        })
    }

    return (
        <div className="p-10 justify-center">
            <Head>
                <title>Create Comment</title>
            </Head>
            <div>
                <div className="prose lg:prose-xl py-2 mb-5">
                    <h1>Create Comment</h1>
                </div>
                <div className="container glass xl:rounded-box p-10 w-10/12">
                    <div className="card bg-base-100 shadow-xl mx-auto max-w-5xl prose lg:prose-xl">
                        <div className="card-body">
                            <div className="card-title flex-col items-start content-start">
                                <h2 className="!m-0">{article.title}</h2>
                                <h5 className="">by {article.author}</h5>
                            </div>
                            <h5 className="text-xs opacity-50">{article.timestamp}</h5>
                            <div className="divider !my-1"></div>
                            <p className="!mt-0">{article.content}</p>
                        </div>
                    </div>
                    <br/>
                    <div className="container card bg-base-300/75 prose lg:prose-xl max-w-5xl p-7 bg-inherit/75">
                        <h3>Comments</h3>
                        <div className="card bg-zinc-600/50 shadow-xl mx-auto w-full not-prose">
                            <form onSubmit={handleSubmit} className="card-body gap-4 items-end">
                                <div className="form-control w-full">
                                    <label className="label">
                                        <span className="label-text font-bold">Author</span>
                                    </label>
                                    <input
                                        type="text"
                                        value={author}
                                        onChange={(e) => setAuthor(e.target.value)}
                                        className="input input-bordered w-full"
                                        placeholder="Type here"
                                    />
                                </div>
                                <div className="form-control w-full">
                                    <label className="label">
                                        <span className="label-text font-bold">Content</span>
                                    </label>
                                    <textarea
                                        value={content}
                                        onChange={(e) => setContent(e.target.value)}
                                        className="textarea textarea-bordered"
                                        placeholder="Type here">
                                    </textarea>
                                </div>
                                <div></div>
                                <div className="card-actions justify-between items-end">
                                    <div className="flex gap-3">
                                        <button className="btn btn-error text-white" type="button">
                                            <Link href={`/articles/${article.id}`}>Cancel</Link>
                                        </button>
                                        {!isMutating ? (
                                            <button className="btn btn-primary" type="submit">Comment</button>
                                        ) : (
                                            <button className="btn btn-primary loading" type="submit">Commenting...</button>
                                        )}
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export async function getServerSideProps({params}: {params: {id: number}}) {
    const fetchArticle = await fetch(`http://localhost:8080/api/v1/article/get-post/${params.id}`, {
        cache: "no-store",
    })
    const dataArticle = await fetchArticle.json()

    return {
        props: { article: dataArticle },
    }
}